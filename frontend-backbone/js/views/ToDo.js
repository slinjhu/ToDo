var app = app || {};

app.viewToDo = Backbone.View.extend({
    tagName: "li",
    className: "list-group-item",
    template: _.template($("#todo-item").html()),
    render: function(){
        var content = this.template(this.model.toJSON());
        this.$el.html(content);
        return this;
    },
    events: {
        "click .toggle": function(){
            this.model.toggle();
        },
        "click .delete": function(){
            this.model.destroy();
        },
        "click .save": function(){
            const title = this.$el.find(".todo-title").text();
            this.model.save({title: title});
        }
    },
    initialize: function() {
        this.listenTo(this.model, "change", this.render);
        this.listenTo(this.model, "destroy", this.remove);
    }
});
