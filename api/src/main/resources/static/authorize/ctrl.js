var app = angular.module("app",[]);

app.controller("ctrl", function ($scope, $http){
    $http.get("http://localhost:8090/rest/authorize").then(resp => {
        $scope.db = resp.data;
    }).catch(error =>{
        console.log(error);
    });

    $scope.index_of = function (username, role){
        return $scope.db.authorities.findIndex(a => a.account.userName == username && a.role.id == role);
    }

    $scope.update = function (username, role){
        var index = $scope.index_of(username, role);
        if(index >= 0){
            var id = $scope.db.authorities[index].id;
            $http.delete(`http://localhost:8090/rest/authorize/${id}`).then(resp => {
                $scope.db.authorities.splice(index,1);
            })
        }else{
            var authority = {
                account : {userName : username},
                role : {id : role}
            }
            $http.post("http://localhost:8090/rest/authorize",authority).then(resp => {
                $scope.db.authorities.push(resp.data);
            });
        }
    }
})