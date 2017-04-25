var app = app || {};

var tasksView = new app.viewAllToDos({
	collection: app.allToDos
});

$("#allToDos").html(tasksView.render().el);

app.allToDos.fetch();