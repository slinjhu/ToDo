var app = app || {};

app.viewNewToDo = Backbone.View.extend({
    el: "#new-todo",
    events: {
        "keydown": function (e) {
            const ENTER = 13;
            const title = this.$el.val().trim();
            if(e.which === ENTER && title){
                collectionToDo.create({title: title});
                console.log("New todo: " + title);
            }
        }
    }
});