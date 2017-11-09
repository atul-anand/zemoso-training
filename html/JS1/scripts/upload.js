document.getElementById("contact-submit").onclick = function sendMessage() {
    console.log("message");
}

var modal = document.getElementById("myModal");
var btn = document.getElementById("gallery-admin-edit");
var button = document.getElementById("gallery-admin-close");

btn.onclick = function() {
    modal.style.display = "block";
}

button.onclick = function() {
    modal.style.display = "none";
}

window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

var updatePhoto = document.getElementById("upload-image");
var sendMessage = document.getElementById("contact-submit");

updatePhoto.onsubmit = function uploadImage() {
    var image = {};
    var attrs = document.getElementsByClassName("gallery-form-entry");
    console.log(attrs);
    var linkField = attrs[0];
    var nameField = attrs[1];
    var infoField = attrs[2];
    
    console.log(linkField);
    console.log(nameField);
    console.log(infoField);
    
    var link = linkField.value;
    var name = nameField.value;
    var info = infoField.value;
    
    console.log(link);
    console.log(name);
    console.log(info);
    
    image.url = link;
    image.name = name;
    image.info = info;
    
    console.log(image);
//    closeAdmin();
    return false;
}
