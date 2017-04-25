var app = app || {};

app.ToDo = Backbone.Model.extend({
	defaults: {
		title: "Title",
		done: false
	},
	toggle: function(){
		this.save({done: !this.get("done")});
		console.log((this.get("done") ? "Done: " : "Undone: ") + this.get("title"));
	}
});
