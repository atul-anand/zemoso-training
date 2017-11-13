console.log(images);

function getImageString(link) {
    var li = document.createElement("li");
    var img = document.createElement("img");
    var overlay = document.createElement("div");
    img.src = link;
    img.classList.add("image");
    overlay.classList.add("image-overlay");
    var editBtn = document.createElement("button");
    editBtn.innerHTML = "Edit";
    editBtn.classList.add("overlay-button");
    editBtn.onclick = function() {
        var json = getJSON(link);
        fillDetails(json);
    }
    var delBtn = document.createElement("button");
    delBtn.innerHTML = "Delete";
    delBtn.classList.add("overlay-button");
    delBtn.onclick = function() {
        var json = getJSON(link);
        console.log(json);
        for(var i=0;i<images.length;i++){
            if(images[i]==json){
                console.log("Check");
                console.log(images[i]);
                images.splice(i,1);
                updateImages();
                console.log(images);
                break;
            }
        }
    }
    var buttons = document.createElement("div");
    buttons.classList.add("overlay-buttons");
    buttons.appendChild(editBtn);
    buttons.appendChild(delBtn);
    overlay.appendChild(buttons);
    li.classList.add("grid-list");
    li.appendChild(img);
    li.appendChild(overlay);
    console.log(li);
    return li;
}

function addBlank(){
    var img = document.createElement("img");
    img.id="add-image";
    img.src="images/add.jpg";
    var div = document.createElement("div");
    div.classList.add("image-overlay");
    var li = document.createElement("li");
    li.classList.add("grid-list");
    li.id="list-add-image";
    li.appendChild(img);
    li.appendChild(div);
    li.addEventListener("click",addImage);
    return li;
}
function populateImages() {
    var grid = document.getElementById("photogrid");
    console.log(grid);
    var ul = document.createElement("ul");
    ul.id = "photo-grid";
    ul.classList.add("grid");
    ul.appendChild(addBlank());
    console.log(ul);
    for(var elem in images) {
        var element = images[elem];
        var url = element.url;
//        console.log(url);
        var li = getImageString(url);
        console.log(li);
        ul.appendChild(li);
    }
    grid.appendChild(ul);
    console.log(grid);
//    disableEditing();
//    console.log(ul);
}
function updateImages() {
    var grid = document.getElementById("photogrid");
    grid.innerHTML = "";
    console.log(grid);
    populateImages();
    document.getElementById("list-add-image").style.display = "inline-block";
    
}
function getJSON(link){
    for(var elem in images){
        var element = images[elem];
        var url = element.url;
        if(link==url)
            return element;
    }
    return null;
}
populateImages();
disableEditing();


document.getElementById("gallery-admin-edit").onclick = function editImages() {
    var editImages = document.getElementById("gallery-admin-edit");
    var text = editImages.innerHTML;
    console.log(text);
    if(text=="Edit Photos"){
        editImages.innerHTML = "Done Editing";
        var li = document.getElementById("list-add-image");
        li.style.display = "inline-block";
        li.addEventListener("click",addImage);
        enableEditing();
    }
    else {
        editImages.innerHTML = "Edit Photos";
        document.getElementById("list-add-image").style.display = "none";
        disableEditing();
    }
    

}
function disableEditing(){
    var liList = document.getElementsByClassName("grid-list");
    console.log(liList.length);
    for(var imgs=1;imgs<liList.length;imgs++){
        var li = liList[imgs];
        console.log(li);
        var img = li.getElementsByTagName("img")[0];
//        img = img[0];
        console.log(img);
        if(img.src=="images/add.jpg")
            continue;
        img.onmouseover = function() {
            this.style.opacity = 1;
        }
        img.onmouseout = function() {
            this.style.opacity = 1;
        }
        
        var imgOverlay = li.getElementsByTagName("div")[0];
        console.log(imgOverlay);
        imgOverlay.style.display = "none";
        console.log(imgOverlay);
    }
}
function enableEditing(){
    var imageList = document.getElementsByClassName("grid-list");
    console.log(imageList);
    for(var imgs=1;imgs<imageList.length;imgs++){
        var li = imageList[imgs];
        console.log(li);
        var img = li.getElementsByTagName("img")[0];
//      
        console.log(img);
        img.onmouseover = function() {
            this.style.opacity = .3;
        }
        img.onmouseout = function() {
            this.style.opacity = 1;
        }
        
        var imgOverlay = li.getElementsByTagName("div")[0];
        console.log(imgOverlay);
        imgOverlay.style.display = "block";
    }
}
var addImage = function addImage() {
    console.log(this);
    document.getElementById("myModal").style.display = "block";
//    document.getElementById("background-overlay").style.display = "block";
}
document.getElementById("gallery-admin-close").onclick = function closeAdmin() {
    uploadImage();
    document.getElementById("myModal").style.display = "none";
//    document.getElementById("background-overlay").style.display = "none";
    
}
function fillDetails(json){
    var form = document.getElementById("gallery-form");
    
    console.log(form);
    console.log(json);
    document.getElementById("myModal").style.display = "block";
//    document.getElementById("background-overlay").style.display = "block";
    var fields = form.getElementsByClassName("gallery-form-entry");
    console.log(fields);
    var linkField = fields[0];
    var nameField = fields[1];
    var infoField = fields[2];
    
    var link = json.url;
    var name = json.name;
    var info = json.info;
    
    linkField.value = link;
    nameField.value = name;
    infoField.value = info;
    console.log(linkField);
}