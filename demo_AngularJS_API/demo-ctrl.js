// let host = "https://poly-java6-db492-default-rtdb.asia-southeast1.firebasedatabase.app";
let host = "http://localhost:8090/rest";
const app = angular.module("app",[]);
app.controller("ctrl", function($scope,$http){
    $scope.form = {}
    $scope.items = []
    $scope.reset = function (){
        $scope.form = {gender : true, country : "VN"};
        // $scope.key = null;
    }
    $scope.load_all = function (){
        var url = `${host}/students`; // nếu làm việc với firebase + .json sau chuỗi api
        $http.get(url).then(resp => {
            $scope.items = resp.data;
            console.log("Success",resp);
        }).catch(error => {
            console.log("Error",error);
        });
    }
    $scope.edit = function (email){
        var url = `${host}/students/${email}`;
        $http.get(url).then(resp =>{
            $scope.form = resp.data;
            // console.log("Success", resp);
        }).catch(error => {
            console.log("Error",error);
        })
    }
    $scope.update = function (){
        var item = angular.copy($scope.form);
        var url = `${host}/students/${$scope.form.email}`;
        $http.put(url,item).then(resp => {
            // $scope.items[$scope.key] = resp.data;
            var index = $scope.items.findIndex(item => item.email == $scope.form.email);
            $scope.items[index] = resp.data;
            // console.log("Success",resp);
            console.log("items: ",index);
        }).catch(error =>{
            console.log("Error",error);
        })
    }
    $scope.delete = function (email){
        var url = `${host}/students/${email}`;
        $http.delete(url).then(resp => {
            // delete $scope.items[key];
            var index = $scope.items.findIndex(item => item.email==$scope.items.email);
            $scope.items.splice(index,1);
            $scope.reset();
            console.log("Succes",resp);
        }).catch(er =>{
            console.log("Error",er);
        })
    }
    $scope.create = function(){
        var item = angular.copy($scope.form);
        var url = `${host}/students`;
        $http.post(url,item).then(resp => {
            // $scope.key = resp.data.name;  dòng lệnh này là khi làm việc với firebase
            // $scope.items[$scope.key] = item;
            $scope.items.push(item);
            $scope.reset();
            console.log("Success",resp);
        }).catch(er => {
            console.log("Error",er);
        })
    }
    //Tải toàn bộ student
    $scope.load_all();
    $scope.reset();
})