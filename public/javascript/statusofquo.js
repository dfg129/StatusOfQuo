

(function(module) {
	module.controller("SOQController", ["$scope", "Restangular", function($scope, Restangular) {
	  
		$scope.photos = buildPhotoSet();

        var getArticles = function () {
        	var articles = Restangular.all('articles');
            articles.getList().then(function(articles) {
            	$scope.articles = articles[0];
        	});
        }

	    var articleREST = Restangular.one('articles', '1');

	    $scope.addArticle = function () {
	    	articlesREST.post('article', newArticle);
	    };

	    getArticles();
	    
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
			template: '<a>On communication:  We start with how to talk  ::   2015-03-01</a>',
			link: function(scope, element, attrs) {
				element.addClass("lede");
			}
		}
	});

}(angular.module("StatusOfQuo", ["restangular"])));



function buildPhotoSet( ) {
	var photos = [];

	photos.push( {
		id : 1,
		src: ( "images/statusofquo.jpg" )
	} );

	return photos;
}


"In an age when few people could read or write , stained glassed windows became the muli-media of the day ~ on Cathedrals"