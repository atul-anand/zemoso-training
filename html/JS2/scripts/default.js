addItems();
addTables();
function getItem(itemId){
//    itemId="item"+itemId;
    console.log(itemId);
    for(var item in items){
        var itm = items[item];
        var id = itm.id;
//        id="item"+id;
        console.log(id);
//        id = id.splice(4);
        if(itemId==id)
            return itm;
    }
    return null;
}
function getCount(orders){
    var count = 0;
    for(var x in orders){
        var order = orders[x];
        console.log(order);
        count+=order.serving;
    }
    console.log(count);
    return count;
}
function getTable(tableId){
    console.log(tableId);
//    tableId="Table"+tableId;
    for(var item in tables){
        var tbl = tables[item];
        var id = tbl.id;
        console.log(id);
        if(tableId==id)
            return tbl;
    }
    return null;
}
function getTableByName(tableName){
    console.log(tableName);
//    tableId="Table"+tableId;
    for(var item in tables){
        var tbl = tables[item];
        var name = tbl.name;
        console.log(name);
        if(tableName==name)
            return tbl;
    }
    return null;
}
function getTotal(table){
	var total = 0;
    console.log(table.order.length);
	for(var x in table.order){
        var item = table.order[x];
        total += item.price*item.serving;
	}
    console.log(total);
	return total;
}


//function getBill(order){
////    var bill = 0;
////    for(var x in order){
//////        try{
////            var ord = order[x];
////            console.log(ord);
////        if(ord==null)
////            continue;
//            return order.price*order.serving;
////            console.log(price);
////            bill+=price;
////        } catch {
////            console.log("Null");
////        }
////        
////    }
////    console.log(bill);
////    return price;
//}


function addItemToTable(table, item){
    console.log(table);
    console.log(item);
    var itemId = item.id;
    var orders = table.order;
    var flag = false;
    console.log(orders.length);
    for(var x in orders){
        var order = orders[x];
        var id = order.id;
        console.log(itemId);
        console.log(id);
        if(itemId==id){
            table.order[x].serving++;
            flag = true;
        }        
    }
    if(flag==false){
        table.order.push(item);
    }
    table.bill+=item.price;
    var tables = document.getElementById("tables");
    console.log(tables);
    var lis = tables.getElementsByTagName("li");
    console.log(lis);
    var tableId = table.id;
    for(var x in lis){
        var li = lis[x];
        console.log(li);
        var id = li.id;
        if(id==tableId){
        
            var h4 = li.getElementsByTagName("h4");
            console.log(h4);
            h4[0].innerHTML = tableBody(table);        
            break;
        }
    }
    
}

function addTable(n){
	var table = {};
	for(var i=0;i<n;i++){
		table = {
            "name": "Table" + (tables.length),
			"id": tables.length,
			"order" : [],
            "bill": 0
		};
        console.log(table);
		tables.push(table);
	}
}

function addTables() {
    addTable(3);
    var tableContainer = document.getElementById("tables");
    console.log(tableContainer);
    var ul = document.createElement("ul");
    for(var i=0;i<tables.length;i++){
        var table = tables[i];
        var tableId = table.id;
        var li = document.createElement("li");
        li.classList.add("item-list");
        li.id = tableId;
        
        var div = document.createElement("div");
      /*  var overlay = document.createElement("div");
        overlay.classList.add("card-overlay");
    */
        var h3 = document.createElement("h3");
        
        var h4 = document.createElement("h4");
        h4.id = tableId;
        h4.classList.add("inline-text");
        
        h3.innerHTML = table.name;
        h4.innerHTML = tableBody(table);
        h3.classList.add("unselectable");
        h4.classList.add("unselectable");
//        addTableListener(div,tableId);
//        addTableListener(h3,tableId);
//        addTableListener(h4,tableId);
        addTableListener(li,tableId);
        
        li.appendChild(h3);
        li.appendChild(h4);
        
//        li.appendChild(div);
        
        console.log(li);
        
        ul.appendChild(li);
        
    }
    ul=addScrollBar(ul);
    tableContainer.appendChild(ul);
//    tableContainer=addScrollBar(tableContainer);
    console.log(ul);
}


function addItems(){
    var menuContainer = document.getElementById("items");
    console.log(menuContainer);
    var ul = document.createElement("ul");
    for(var i=0;i<items.length;i++){
        var item = items[i];
        var itemId = item.id;
        
        
        var li = document.createElement("li");
        li.classList.add("item-list");
        li.id = itemId;
//        var div = document.createElement("div");
        
        var h3 = document.createElement("h3");
        var h4 = document.createElement("h4");
        h3.innerHTML = item.name;
        h4.innerHTML = "Rs. " + item.price;
        h3.classList.add("unselectable");
        h4.classList.add("unselectable");
        addItemListener(li,itemId);
//        addItemListener(div,itemId);
//        addItemListener(h3,itemId);
//        addItemListener(h4,itemId);
        
//        div.appendChild(h3);
//        div.appendChild(h4);
        li.appendChild(h3);
        li.appendChild(h4);
        console.log(items[i]);
        
        console.log(li.id);
        console.log(li);
//        li.appendChild(div);
        
        
        
        ul.appendChild(li);
//        makeDraggable(li);
        
    }
    ul = addScrollBar(ul);
    menuContainer.appendChild(ul);
//    menuContainer=addScrollBar(menuContainer);
    console.log(menuContainer);
}

function allowDrop(ev) {
    ev.preventDefault();
}

function drag(ev) {
    console.log(ev);
    ev.dataTransfer.setData("text", ev.target.id);
    console.log(ev.target.id);
    ev.stopPropagation();
}

function drop(ev) {
    ev.preventDefault();
    var itemId = ev.dataTransfer.getData("text");
//    console.log(itemId);
    var item = getItem(itemId);
    console.log(item);
    var tableId = ev.target.id;
//    console.log(tableId);
    var table = getTable(tableId);
    console.log(table);
    addItemToTable(table,item);
    
    console.log(tables);
//    updateTable(table);
    ev.stopPropagation();
}
function showDetails(ev){
//    console.log(ev);
    var tableId = ev.target.id;
    console.log(tableId);
    var dialog = document.getElementById("dialog");
    
//    console.log(dialog);
    var table = getTable(tableId);
    console.log(table);
    console.log(dialog);
    console.log(table.order.length);
    dialog.style.display = "block";
    var info = document.getElementById("table-info");
    info.innerHTML = table.name;
    var tableGrp = document.getElementById("dialog-tbl");
//    var tableHead = document.getElementById("dialog-table-head");
//    var tableBody = document.getElementById("dialog-table");
    tableGrp.innerHTML = "";
    
    if(table.order.length>0){
        tableGrp.appendChild(addHeadingToTable());    
        console.log(tableGrp);
        tableGrp.style.display = "block";
        
        console.log(table);
//        table = fixServings(table);

        tableGrp = addItemsToBody(table,tableGrp);

        tableGrp.appendChild(addTotalRow(table));
        console.log(tableGrp);
    } else {
        
    
        tableGrp.appendChild(noOrdersScreen());
        
//        tableGrp.style.display = "none";
        console.log(tableGrp);
    }
    
    
    
//    tableName.innerHTML = table.name;
    
    
}

function addItemListener(li,id){
    li.id = id;
    li.addEventListener('dragstart',function(event){drag(event);});
}


function addTableListener(li,id){
    li.id = id;
    
    li.addEventListener('click',function(event){showDetails(event);});
    li.addEventListener('drop',function(event){drop(event);});
    li.addEventListener('dragover',function(event){allowDrop(event);});
}

function wipeTable(table){
    var menu = document.getElementById("tables");
    var lis = document.getElementsByTagName("li");
    var li = null;
    console.log(table);
    for(var x in lis){
        li = lis[x];
        if(li.id==table.id){
            break;
        }
    }
    if(li!=null){
        var id = li.id;
        console.log(li.parentElement);
        li.parentElement.removeChild(li);
    }
    
    for(var x in tables){
        var tbl = tables[x];
        if(tbl==table){
            tables.remove(table);
            break;
        }
    }
}

function handleQuantityChange() {
    
//    console.log(table);
    console.log(this);  
    var modalBody = document.getElementsByClassName("modal-title-right")[0];
    var table = getTableByName(modalBody.innerHTML);
    console.log(modalBody);
    var total = document.getElementById("total-bill");
    input = this;
    console.log(input.value);
    var newServings = input.value;
    console.log(newServings);
    var itemId = input.id;
    console.log(itemId);
    console.log(table.order);
    for(var x in table.order){
        var id = table.order[x].id;
        console.log(id);
        if(id==itemId){
            table.order[x].serving = Number(newServings);    
            console.log(table.order[x]);
        }
    }
    
    
    console.log(table);
    var totalBill = getTotal(table);
    table.bill = totalBill;
    console.log(table);
    
    updateTableList(table);
    console.log(totalBill);
    total.innerHTML = totalBill;
    
}
function updateTableList(table){
    var tables = document.getElementById("tables");
    var lis = tables.getElementsByClassName("item-list");
    console.log(lis);
//    var tableName = document.getElementById("table-info");
//    var table = getTableByName(tableName);
    console.log(table);
    var h4s = tables.getElementsByTagName("h4");
    for(var x in h4s){
        var h4 = h4s[x];
        var h4id = h4.id;
        if(h4id==table.id){
            console.log(h4);
            h4.innerHTML=tableBody(table);
            console.log(h4);
        }
        
    }
}
document.getElementById("agree-modal").onclick = function() {
    var modal = document.getElementById("myModal");
    console.log("Generating Bill");
    var tableName = document.getElementById("table-info");
    var table = getTableByName(tableName.innerHTML);
    console.log(tableName);
    console.log(table);
    modal.style.display = "none";
    wipeTable(table);
    
}

document.getElementById("disagree-modal").onclick = function() {
    var modal = document.getElementById("myModal");
    modal.style.display = "none";
    
}


function tableBody(table){
    var orders = table.order;
    console.log(orders);
    var str = "Rs. ";
    str+=table.bill;
    str+=" | Items: ";
    str+=getCount(orders);
    console.log(str);
    return str;
}

function addIncrementor(value,itemId,table){
    var div = document.createElement("div");
    var h5 = document.createElement("h5");
    h5.innerHTML = "Number of servings";
    h5.classList.add("incremnetor-heading");
    var input = document.createElement("input");
    input.type = "number";
    input.id = itemId;
    input.classList.add("incrementor");
    input.value = value;
    input.min = 1;
    input.oninput = handleQuantityChange;
//    input.onkeypress = handleQuantityChange(table,input);
    div.appendChild(h5);
    div.appendChild(input);
    return div;
}

function addDeleteButton(){
    var div = document.createElement("div");
    return div;
}
function addTotalRow(table) {
    var tfoot = document.createElement("tfoot");
    var tr = document.createElement("tr");
    tr.id = "Total";
    
    var sno = document.createElement("td");
    var item = document.createElement("td");
    var price = document.createElement("td");
    var quantity = document.createElement("td");
    var del = document.createElement("td");
    

    sno.classList.add("dialog-body-item");
    item.classList.add("dialog-body-item");
    price.classList.add("dialog-body-item");
    quantity.classList.add("dialog-body-item");
    del.classList.add("dialog-body-item");
    
    sno.innerHTML = "";
    item.innerHTML = "Total";
    price.id = "total-bill";
    price.innerHTML = table.bill;
    quantity.innerHTML = "";
    
    
    tr.appendChild(sno);
    tr.appendChild(item);
    tr.appendChild(price);
    tr.appendChild(quantity);
    tr.appendChild(del);
    
    tfoot.appendChild(tr);
    
    return tfoot;
}
function addItemToBody(order,id,tableId) {
    var table = getTable(tableId);
    var tr = document.createElement("tr");
    tr.id = id;
    
    var sno = document.createElement("td");
    var item = document.createElement("td");
    var price = document.createElement("td");
    var quantity = document.createElement("td");
    var del = document.createElement("td");
    
    console.log(order);
    
    sno.classList.add("dialog-body-item");
    item.classList.add("dialog-body-item");
    price.classList.add("dialog-body-item");
    quantity.classList.add("dialog-body-item");
    del.classList.add("dialog-body-item");
    
    sno.innerHTML = id;
    item.innerHTML = order.name;
    price.innerHTML = order.price;
    quantity.appendChild(addIncrementor(order.serving,id,table));
    del.appendChild(addDeleteButton());
    
    tr.appendChild(sno);
    tr.appendChild(item);
    tr.appendChild(price);
    tr.appendChild(quantity);
    tr.appendChild(del);
    
    return tr;
}

function addItemsToBody(table,body) {
    
    var tbody = document.createElement("tbody");
    
    tbody = addScrollBar(tbody);
    tbody.classList.add("modal-table-body");
    var id = table.id;
    
    var orders = table.order;
    console.log(orders);
    
    for(var x=0;x<orders.length;x++){
        var order = orders[x];
//        var i = x+1;
        var tr = addItemToBody(order,order.id,id);
        console.log(tr);
        tbody.appendChild(tr);
    }
    
    console.log(body);
    body.appendChild(tbody);
    return body;
}


function addHeadingToTable(){
    var thead = document.createElement("thead");
    var tr = document.createElement("tr");
    tr.id = "dialog-heading";
    
    var sno = document.createElement("th");
    var item = document.createElement("th");
    var price = document.createElement("th");
    var quantity = document.createElement("th");
    var del = document.createElement("th");
    
    sno.innerHTML = "S.No";
    item.innerHTML = "Item";
    price.innerHTML = "Price";
    quantity.innerHTML = "Servings";
    del.innerHTML = "Delete?"
    
    sno.classList.add("dialog-heading-item");
    item.classList.add("dialog-heading-item");
    price.classList.add("dialog-heading-item");
    quantity.classList.add("dialog-heading-item");
    del.classList.add("dialog-heading-item");
    
    tr.appendChild(sno);
    tr.appendChild(item);
    tr.appendChild(price);
    tr.appendChild(quantity);
    tr.appendChild(del);
    
    thead.appendChild(tr);
    
    return thead;
}

function noOrdersScreen(){
    var div = document.createElement("div");
    div.classList.add("dialog-empty");
    div.innerHTML = "No items in the cart.";
    return div;
}

function hideScrollBarIfLessElements(tag){
    
}


function addScrollBar(tag){
    
//    var div = document.createElement("div");
//    div.classList.add("force-overflow");
    tag.classList.add("scrollbar");
    tag.id="style-5";
//    tag.appendChild(div);
//    tag.appendChild(scroll);
    return tag;
}


