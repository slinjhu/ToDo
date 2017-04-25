var app = app || {};

var ToDoCollection = Backbone.Collection.extend({
	model: app.ToDo,
	url: "http://localhost:8080/todo"
});

app.allToDos = new ToDoCollection();