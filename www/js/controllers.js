angular.module('app.controllers', [])
  
.controller('contadorCtrl', ['$scope', '$stateParams', // The following is the constructor function for this page's controller. See https://docs.angularjs.org/guide/controller
// You can include any angular dependencies as parameters for this function
// TIP: Access Route Parameters for your page via $stateParams.parameterName        
function ($scope, $stateParams) { 
    $scope.e1=0;
    $scope.v1=0;
    $scope.e2=0;
    $scope.v2=0;
    $scope.comprobar = function(){
        if($scope.e1>=40){
            $scope.e1=0;
            $scope.v1=$scope.v1+1;
            if($scope.v1===3){
                $scope.e1="Ganador";
                $scope.e2="Perdedor";
            }
        }
    }
    $scope.mas1 = function (){
         $scope.e1=$scope.e1 + 1; 
        $scope.comprobar();
    }
    $scope.mas2 = function (){
         $scope.e1=$scope.e1 + 2;
        $scope.comprobar();
    }
    $scope.mas3 = function (){
         $scope.e1=$scope.e1 + 3;
        $scope.comprobar();
    }
    $scope.mas5 = function (){
         $scope.e1=$scope.e1 + 5;
        $scope.comprobar();
    }
    $scope.mas10 = function (){
         $scope.e1=$scope.e1 + 10;
        $scope.comprobar();
    }
    $scope.mas40 = function (){
         $scope.e1=$scope.e1 + 40;
        $scope.comprobar();
    }
    $scope.menos1 = function (){
         $scope.e1=$scope.e1 - 1;
    }
    $scope.menos2 = function (){
         $scope.e1=$scope.e1 - 2;
    }
    $scope.menos3 = function (){
         $scope.e1=$scope.e1 - 3;
    }
    $scope.menos5 = function (){
         $scope.e1=$scope.e1 - 5;
    }
    $scope.menos10 = function (){
         $scope.e1=$scope.e1 - 10;
    }
    $scope.menos40 = function (){
         $scope.e1=$scope.e1 - 40;
    }
    $scope.reset = function (){
        $scope.e1=0;
        $scope.v1=0;
        $scope.e2=0;
        $scope.v2=0;
    }
    
    $scope.comprobarb = function(){
        if($scope.e2>=40){
            $scope.e2=0;
            $scope.v2=$scope.v2+1;
            if($scope.v2===3){
                $scope.e2="Ganador";
                $scope.e1="Perdedor";
            }
        }
    }
    $scope.mas1b = function (){
         $scope.e2=$scope.e2 + 1; 
        $scope.comprobarb();
    }
    $scope.mas2b = function (){
         $scope.e2=$scope.e2 + 2; 
        $scope.comprobarb();
    }
    $scope.mas3b = function (){
         $scope.e2=$scope.e2 + 3; 
        $scope.comprobarb();
    }
    $scope.mas5b = function (){
         $scope.e2=$scope.e2 + 5; 
        $scope.comprobarb();
    }
    $scope.mas10b = function (){
         $scope.e2=$scope.e2 + 10; 
        $scope.comprobarb();
    }
    $scope.mas40b = function (){
         $scope.e2=$scope.e2 + 40; 
        $scope.comprobarb();
    }
    $scope.menos1b = function (){
         $scope.e2=$scope.e2 - 1; 
        $scope.comprobarb();        
    }
    $scope.menos2b = function (){
         $scope.e2=$scope.e2 - 2; 
        $scope.comprobarb();        
    }
    $scope.menos3b = function (){
         $scope.e2=$scope.e2 - 3; 
        $scope.comprobarb();        
    }
    $scope.menos5b = function (){
         $scope.e2=$scope.e2 - 5; 
        $scope.comprobarb();        
    }
    $scope.menos10b = function (){
         $scope.e2=$scope.e2 - 10; 
        $scope.comprobarb();        
    }
    $scope.menos40b = function (){
         $scope.e2=$scope.e2 - 40; 
        $scope.comprobarb();        
    }
}])
      
.controller('acercaDeCtrl', ['$scope', '$stateParams', // The following is the constructor function for this page's controller. See https://docs.angularjs.org/guide/controller
// You can include any angular dependencies as parameters for this function
// TIP: Access Route Parameters for your page via $stateParams.parameterName
function ($scope, $stateParams) {


}])
   
.controller('cMoJugarCtrl', ['$scope', '$stateParams', // The following is the constructor function for this page's controller. See https://docs.angularjs.org/guide/controller
// You can include any angular dependencies as parameters for this function
// TIP: Access Route Parameters for your page via $stateParams.parameterName
function ($scope, $stateParams) {


}])