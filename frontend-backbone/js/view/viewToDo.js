var app = app || {};

app.viewToDo = Backbone.View.extend({
	template: _.template( $("#todo-item").html() ),
	render: function(){
		var todoTemplate = this.template(this.model.toJSON());
		this.$el.html(todoTemplate);
		return this;
	},
	events: {
		"click .toggle": function(){
			this.model.toggle();
		},
		"click .delete": function(){
			console.log("Delete: " + this.model.get("title"));
		}
	},
	initialize: function() {
	    this.listenTo(this.model, "change", this.render);
  	}
});

