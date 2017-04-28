var app = app || {};

var collectionToDo = new app.collectionToDo();
new app.viewCollectionToDo({collection: collectionToDo});
new app.viewNewToDo();
