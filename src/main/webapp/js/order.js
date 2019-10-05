var $itemsTable;

function initItemsTable(items) {	//初始化bootstrap-table的内容
	//var cart = JSON.parse(sessionStorage.getItem('cart'));
	$itemsTable = $('#items_grid').bootstrapTable({
        //method: 'POST',              //请求方式（*）
        striped: true,                      //是否显示行间隔色
        cache: false,                       //是否使用缓存，默认为true，所以一般情况下需要设置一下这个属性（*）
        pagination: false,                   //是否显示分页（*）
        sortable: false,                     //是否启用排序
        //sortOrder: "asc",                   //排序方式
        //sidePagination: "server",           //分页方式：client客户端分页，server服务端分页（*）
        //pageNumber: 1,                      //初始化加载第一页，默认第一页,并记录
        //pageSize: rows,                     //每页的记录行数（*）
        //pageList: [10, 25, 50, 100],        //可供选择的每页的行数（*）
        search: false,                      //是否显示表格搜索
        strictSearch: true,
        showColumns: false,                  //是否显示所有的列（选择显示的列）
        showRefresh: false,                  //是否显示刷新按钮
        minimumCountColumns: 2,             //最少允许的列数
        clickToSelect: true,                //是否启用点击选中行
        //height: 500,                      //行高，如果没有设置height属性，表格自动根据记录条数觉得表格高度
        //uniqueId: "id",                     //每一行的唯一标识，一般为主键列
        showToggle: false,                   //是否显示详细视图和列表视图的切换按钮
        cardView: false,                    //是否显示详细视图
        detailView: false,                  //是否显示父子表
        data: items,
        columns: [ {
        	field: 'Num',
            title: '序号',//标题  可不加
            align: 'center',
            valign: 'middle',
            formatter: function (value, row, index) {
            	row.Num = index + 1;
                return index + 1;
            }
        },{
            field: 'imageUrl',
            title: '实物图片',
            width: 120,
            formatter: imageFormatter
        }, {
            field: 'name',
            title: '商品名称',
            sortable: true
        }, {
            field: 'price',
            title: '单价',
            sortable: true,      
            formatter: itemPriceFormatter
        }, {
            field: 'quantity',
            title: '购买数量'
        }, {
            field:'status',
            title: '状态',
            width: 150,
            align: 'center',
            valign: 'middle'
        }, ],
        onLoadSuccess: function () {
        },
        onLoadError: function () {
            alert("数据加载失败！");
        }
    });
};

function itemPriceFormatter(value, row, index) {	//
    var result = '￥'+value.toFixed(2);
    return result;
}
