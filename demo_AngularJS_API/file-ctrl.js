app = angular.module("app",[]);
app.controller("ctrl", function ($scope, $http) {
    var url = "http://localhost:8090/rest/files/images";
    $scope.url = function (filename){
        return `${url}/${filename}`;
    }

    $scope.list = function () {
        $http.get(url).then( resp => {
            $scope.filenames = resp.data;
        }).catch(error => {
            console.log("Error",error);
        });
    }

    $scope.upload = function (files) {
        var form = new FormData();
        for(var i = 0; i < files.length; i++){
            form.append("files", files[i]);
        }
        $http.post(url,form, {
            transformRequest: angular.indentity,
            headers: {'Content-Type' : undefined}
        }).then(resp => {
            $scope.filenames.push(...resp.data);
        }).catch(error => {
            console.log("Error",error);
        });
    }

    $scope.delete = function (file) {
        $http.delete(`${url}/${file}`).then(resp => {
            let i = $scope.filenames.findIndex(name => name == file);
            $scope.filenames.splice(i,1);
        }).catch(error => {
            console.log("Error",error);
        });
    }

    $scope.list();
})