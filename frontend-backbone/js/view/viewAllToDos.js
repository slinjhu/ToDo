var app = app || {};

app.viewAllToDos = Backbone.View.extend({
	tagName: "ul",
	className: "list-group",
	render: function(){
		this.collection.each(this.addToDo, this);
		return this;
	},
	addToDo: function(todo){
		var todoView = new app.viewToDo({model: todo});
		this.$el.append(todoView.render().el);
	},
	initialize: function() {
		this.listenTo(this.collection, "add", this.addToDo);
  	}
});