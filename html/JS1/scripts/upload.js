function clearContactForm(){
    var form = document.getElementById("contact-form");
    form.reset();
}
document.getElementById("contact-submit").onclick = function sendMessage(event) {
    event.preventDefault();
    
    var name = document.getElementById("form-name").value;
    var email = document.getElementById("form-email").value;
    var msg = document.getElementById("form-message").value;
    console.log(name);
    var message = {
        "name": name,
        "email": email,
        "message": msg
    };
    messages.push(message);
    console.log(message);
    console.log(messages);
//        // Check for the various File API support.
//    if (window.File && window.FileReader && window.FileList && window.Blob) {
//      // Great success! All the File APIs are supported.
//        
//        
        var jsonData = JSON.stringify(messages);
        console.log(jsonData);
        
        
        
        alert("Success" + message + jsonData);
        
        clearContactForm();
//    } else {
//      alert('The File APIs are not fully supported in this browser.');
//    }
    return false;
}

var modal = document.getElementById("myModal");
//var btn = document.getElementById("gallery-admin-edit");
var button = document.getElementById("gallery-admin-close");

//btn.onclick = function() {
//    modal.style.display = "block";
//}

button.onclick = function() {
    modal.style.display = "none";
}

window.onclick = function(event) {
    if (event.target == modal) {
        modal.style.display = "none";
    }
}

var updatePhoto = document.getElementById("upload-image");
//var sendMessage = document.getElementById("contact-submit");

updatePhoto.onclick = function uploadImage(event) {
    event.preventDefault();
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
    images.push(image);
    console.log(images);
    document.getElementById("myModal").style.display = "none";
//    closeAdmin();
    return false;
}
