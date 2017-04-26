var app = {};

//_________________ Models
app.modelToDo = Backbone.Model.extend({
    defaults: {
        title: "Title",
        done: false,
        created: 0,
        modified: 0
    },
    toggle: function(){
        this.save({done: !this.get("done")});
    }
});

//_________________ Collections
app.collectionToDo = Backbone.Collection.extend({
    model: app.modelToDo,
    url: "/todo"
});

//________________ Views
app.viewToDo = Backbone.View.extend({
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

var collectionToDo = new app.collectionToDo();
new app.viewCollectionToDo({collection: collectionToDo});
new app.viewNewToDo();
