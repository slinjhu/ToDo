var app = app || {};

app.allToDos.fetch();

console.log(app.allToDos);

var tasksView = new app.viewAllToDos({
	collection: app.allToDos
});

$("#allToDos").html(tasksView.render().el);

