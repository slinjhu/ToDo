var app = app || {};

app.ToDo = Backbone.Model.extend({
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
