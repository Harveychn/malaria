var map = new BMap.Map("container");
var point = new BMap.Point(116.331398, 39.897445);
map.centerAndZoom(point, 12);

function myFun(result) 
{
	var cityName = result.name;
	map.setCenter(cityName);
	console.log(cityName);
}
var myCity = new BMap.LocalCity();
myCity.get(myFun);