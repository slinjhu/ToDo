var app = app || {};

app.modelToDo = Backbone.Model.extend({
    defaults: {
        title: "Title",
        done: false
    },
    toggle: function(){
        this.save({done: !this.get("done")});
    }
});