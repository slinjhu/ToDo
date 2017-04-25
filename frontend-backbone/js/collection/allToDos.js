var app = app || {};

var ToDoCollection = Backbone.Collection.extend({
	model: app.ToDo
});

app.allToDos = new ToDoCollection();