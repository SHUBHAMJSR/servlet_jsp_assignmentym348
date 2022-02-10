

function validate() {
    let prodName = document.getElementById("pnameId").value;
    let prodPrice = document.getElementById("pprice").value;
    let quantity = document.getElementById("qtyid").value;
    let manufacturedDate = document.getElementById("manudateid").value;
    let inspectionDate = document.getElementById("inpdateid").value

    if (isBlank(prodName)) {
        document.getElementById("pnamelabel").innerHTML = "Enter product name";
        document.getElementById("pnamelabel").style.color = "red";
        return false;
    }

    if (isBlank(prodPrice)) {
        document.getElementById("priceProd").innerHTML = "Enter price of product";
        document.getElementById("priceProd").style.color = "red";
        return false;
    }

    if (isBlank(quantity)) {
        document.getElementById("qtylabel").innerHTML = "Enter Quantity of product";
        document.getElementById("qtylabel").style.color = "red";
        return false;
    }

    if (isBlank(manufacturedDate)) {
        document.getElementById("manulabel").innerHTML = "Enter Maufactured Date";
        document.getElementById("manulabel").style.color = "red";
        return false;
    }
    
    if (isBlank(inspectionDate)) {
        document.getElementById("inplabel").innerHTML = "Enter Inspection Date";
        document.getElementById("inplabel").style.color = "red";
        return false;
    }
 
    return true;
}
function isBlank(val) {
    return (val.trim() == "") ? true : false;
}