var searchTableElement = document.getElementById("menu-search");
var searchItemsElement = document.getElementById("main-search");
function checkName(name,string){
    if(name.indexOf(string)==-1)
        return true;
    return false;
}
function searchTable(){
//    var searchTableElement = ;

//    console.log(searchTableElement);
    var searchString = document.getElementById('menu-search').value;
    console.log(searchString);
	var tableDivs = document.getElementById('tables').getElementsByTagName('li');
	var li;
	for(var i=0;i<tableDivs.length;i++){
		li = tableDivs[i];
        var id = li.id;
        var table = getTable(id);
        console.log(table.name);
        console.log(li.id);
        var x = checkName(table.name,searchString);
        console.log(x);
        
		if(searchString.length && checkName(table.name,searchString)){
            console.log("hidden");
			li.style.display = 'none';
		} else {
            console.log("shown");
			li.style.display = 'block';
		}
	}
}

function searchItems(){
//    var searchItemsElement = ;

//    console.log(searchItemsElement);
    var searchString = document.getElementById('main-search').value;
    console.log(searchString);
	var itemsDivs = document.getElementById('items').getElementsByTagName('li');
	var li;
	for(var i=0;i<itemsDivs.length;i++){
		li = itemsDivs[i];
        var id = li.id;
        var item = getItem(id);
        console.log(item.name);
        console.log(li.id);
        var x = checkName(item.name,searchString);
        console.log(x);
        
		if(searchString.length && checkName(item.name,searchString)){
            console.log("hidden");
			li.style.display = 'none';
		} else {
            console.log("shown");
			li.style.display = 'block';
		}
	}
}


searchTableElement.oninput = searchTable();
searchItemsElement.oninput = searchItems();