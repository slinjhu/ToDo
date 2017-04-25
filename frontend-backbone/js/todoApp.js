
app.allToDos.add(new app.ToDo({title: "Improve UT coverage"}));
app.allToDos.add(new app.ToDo({title: "Fix bug", done: true}));


var tasksView = new app.viewAllToDos({
	collection: app.allToDos
});

$("#allToDos").html(tasksView.render().el);

