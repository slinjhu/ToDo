var app = app || {};

app.viewAllToDos = Backbone.View.extend({
	tagName: "ul",
	render: function(){
		this.collection.each(this.addToDo, this);
		return this;
	},
	addToDo: function(todo){
		var todoView = new app.viewToDo({model: todo});
		this.$el.append(todoView.render().el);
	}
});