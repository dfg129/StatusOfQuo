

(function (module) {
  module.config(function ($componentLoaderProvider) {
  
   $componentLoaderProvider.setTemplateMapping(function (name) {
     // name == component name
     return '/assets/components/' + name + '/' + name + '.html';
   });
  });

  module.controller('SOQController', ['$scope', '$router', function ($scope, $router) {
  

  $router.config([
  	 { path: '/', component: 'intro' },
     { path: 'article', component: 'article' }
  	 ]);

        var getArticles = function () {
        //	var articles = Restangular.all('articles');
      //      articles.getList().then(function(articles) {
      //      	$scope.articles = articles[0];
      //  	});
        }

	  //  $scope.addArticle = function () {
	 //   	articlesREST.post('article', newArticle);
	 //   };

	  //  getArticles();
	    
	}]);
 
	  module.directive("mainView", function() {
		return {
			restrict: 'A',
			templateUrl: '/assets/partials/main.view.html',
			link: function(scope, element, attrs) {
				element.css('height', '90%');
			}
		}
	});


	module.directive("poem", function() {
		return {
			restrict: 'A',
			templateUrl: '/assets/partials/poem.view.html',
			link: function(scope, element, attrs) {
				element.addClass("things");
			}
		}
	});

	module.directive("tech", function() {
		return {
			restrict: 'A',
			templateUrl: '/assets/partials/link.view.html',
			link: function(scope, element, attrs) {
				element.addClass("lede");
			}
		}
	});

}(angular.module('StatusOfQuo', ['ngNewRouter', 'ngAnimate', 'StatusOfQuo.article', 'StatusOfQuo.intro'])));



function buildPhotoSet( ) {
	var photos = [];

	photos.push( {
		id : 1,
		src: ( "images/statusofquo.jpg" )
	} );

	return photos;
}

