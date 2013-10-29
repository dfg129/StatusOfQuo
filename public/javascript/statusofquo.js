

(function(module) {
	module.controller("SOQController", ["$scope", "Restangular", function($scope, Restangular) {
	  
        $scope.getArticles = function () {
        	var articles = Restangular.all('articles');
            articles.getList().then(function(articles) {
            	$scope.articles = articles[0];
        	});
        }

	    var articleREST = Restangular.one('articles', '1');

	    $scope.addArticle = function () {
	    	articlesREST.post('article', newArticle);
	    }

	    var newArticle = {
	    	name: "Article 1",
	    	length:"1"
	    }
	    
	}]);
 

	module.directive("article", function() {
		return {
			restrict: 'A',
			template: '<ul>' +
			              '<li ng-repeat="article in articles"' +
			                   '<h1>Article</h1><span>{{article.name}}</span>' +
			              '</li>' +
			          '</ul>',
			link: function(scope, element, attrs) {
				
			}
		}
	});

}(angular.module("StatusOfQuo", ["restangular"])));