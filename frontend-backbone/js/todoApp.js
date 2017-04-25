var app = app || {};

app.allToDos.fetch();

var tasksView = new app.viewAllToDos({
	collection: app.allToDos
});

$("#allToDos").html(tasksView.render().el);

