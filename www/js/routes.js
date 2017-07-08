angular.module('app.routes', [])

.config(function($stateProvider, $urlRouterProvider) {

  // Ionic uses AngularUI Router which uses the concept of states
  // Learn more here: https://github.com/angular-ui/ui-router
  // Set up the various states which the app can be in.
  // Each state's controller can be found in controllers.js
  $stateProvider
    
  

      .state('tabsController.contador', {
    url: '/page1',
    views: {
      'tab1': {
        templateUrl: 'templates/contador.html',
        controller: 'contadorCtrl'
      }
    }
  })

  .state('tabsController', {
    url: '/page1',
    templateUrl: 'templates/tabsController.html',
    abstract:true
  })

  .state('tabsController.acercaDe', {
    url: '/page3',
    views: {
      'tab3': {
        templateUrl: 'templates/acercaDe.html',
        controller: 'acercaDeCtrl'
      }
    }
  })

  .state('tabsController.cMoJugar', {
    url: '/page2',
    views: {
      'tab4': {
        templateUrl: 'templates/cMoJugar.html',
        controller: 'cMoJugarCtrl'
      }
    }
  })

$urlRouterProvider.otherwise('/page1/page1')

  

});