

(function(module) {
	module.controller("SOQController", ["$scope", "Restangular", function($scope, Restangular) {
	  
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
 

	module.directive("article", function() {
		return {
			restrict: 'A',
			templateUrl: '/views/articles.view.html',
			link: function(scope, element, attrs) {
				
			}
		}
	});

}(angular.module("StatusOfQuo", ["restangular"])));