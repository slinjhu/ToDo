var app = app || {};

app.viewCollectionToDo = Backbone.View.extend({
    el: "#all-todo",
    addToDo: function(todo){
        var todoView = new app.viewToDo({model: todo});
        this.$el.append(todoView.render().el);
    },
    initialize: function() {
        this.listenTo(this.collection, "add", this.addToDo);
        this.collection.fetch();
        this.render();
    }
});