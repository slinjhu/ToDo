var app = app || {};

app.viewToDo = Backbone.View.extend({
	tagName: "li",
	template: _.template( $("#todo-item").html() ),
	render: function(){
		var todoTemplate = this.template(this.model.toJSON());
		this.$el.html(todoTemplate);
		return this;
	},
	events: {
		"mouseover": "addBgColor",
		"mouseout": "removeBgColor",
		"click .toggle": "toggleDone"
	},
	addBgColor: function(){
		this.$el.addClass("withBgColor");
	},
	removeBgColor: function(){
		this.$el.removeClass("withBgColor");
	},
	toggleDone: function(){
		this.model.toggle();
		this.render();
	}
});

