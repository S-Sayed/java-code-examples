function search(){
	$("#totalNoOfHandsets").empty();
	$("#handsetsTableBody").empty();
	
	var queryParams = fillQueryParams();
	console.log("queryParams ", queryParams);
	
	 $.ajax({
        url: "http://localhost:8899/mobile/search?" + queryParams
    }).then(function(data) {
		console.log('data', data);
		$("#totalNoOfHandsets").append("<strong>Total: </strong>").append(data.total);
		fillHandsetsTableRows(data.handsets);
    });
}

function fillQueryParams() 
{
	var id = $('#id').val();
	var brand = $('#brand').val();
	var phone = $('#phone').val();
	var picture = $('#picture').val();
	var announceDate = $('#announceDate').val();
	var priceEur = $('#priceEur').val();
	var sim = $('#sim').val();
	var resolution = $('#resolution').val();
	var audioJack = $('#audioJack').val();
	var gps = $('#gps').val();
	var battery = $('#battery').val();
	
	
	var queryParams = "";
	
	if(id) {
		queryParams += "id=" + id;
	}
	
	if(brand) {
		queryParams += queryParams ? '&' : '';
		queryParams += "brand=" + brand;
	}
	
	if(phone) {
		queryParams += queryParams ? '&' : '';
		queryParams += "phone=" + phone;
	}
	
	if(picture) {
		queryParams += queryParams ? '&' : '';
		queryParams += "picture=" + picture;
	}
	
	
	if(announceDate) {
		queryParams += queryParams ? '&' : '';
		queryParams += "announceDate=" + announceDate;
	}
	
	if(priceEur) {
		queryParams += queryParams ? '&' : '';
		queryParams += "priceEur=" + priceEur;
	}
	
	if(sim) {
		queryParams += queryParams ? '&' : '';
		queryParams += "sim=" + sim;
	}
	
	if(resolution) {
		queryParams += queryParams ? '&' : '';
		queryParams += "resolution=" + resolution;
	}
	
	if(audioJack) {
		queryParams += queryParams ? '&' : '';
		queryParams += "audioJack=" + audioJack;
	}
	
	if(gps) {
		queryParams += queryParams ? '&' : '';
		queryParams += "gps=" + gps;
	}
	
	if(battery) {
		queryParams += queryParams ? '&' : '';
		queryParams += "battery=" + battery;
	}
	
	return queryParams;
}

function fillHandsetsTableRows(handsets) {
    var handsetsTableBody = $('#handsetsTableBody');
	
    for (var i = 0; i < handsets.length; i++) {
        var tr = $('<tr/>').appendTo(handsetsTableBody);
		tr.append('<td>' + (i + 1) + '</td>');
        tr.append('<td>' + handsets[i].id + '</td>');
		tr.append('<td>' + handsets[i].brand + '</td>');
		tr.append('<td>' + handsets[i].phone + '</td>');
		tr.append('<td>' + handsets[i].picture + '</td>');
		tr.append('<td>' + handsets[i].release.announceDate + '</td>');
		tr.append('<td>' + handsets[i].release.priceEur + '</td>');
		tr.append('<td>' + handsets[i].sim + '</td>');
		tr.append('<td>' + handsets[i].resolution + '</td>');
		tr.append('<td>' + handsets[i].hardware.audioJack + '</td>');
		tr.append('<td>' + handsets[i].hardware.gps + '</td>');
		tr.append('<td>' + handsets[i].hardware.battery + '</td>');	
    }
}