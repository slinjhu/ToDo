var app = app || {};

app.collectionToDo = Backbone.Collection.extend({
    model: app.modelToDo,
    url: "http://localhost:7000/todo"
});
