var app = app || {};

var viewNewToDo = Backbone.View.extend({
    el: "#new-todo",
    events: {
        "keydown": function(e){
            const ENTER = 13;
            if(e.which === ENTER){
                let title = this.$el.val().trim();
                if(title){
                    app.allToDos.create({title: title});
                    console.log("New todo: " + title);
                }                
            }            
        }
    }
});

app.viewNewToDo = new viewNewToDo();