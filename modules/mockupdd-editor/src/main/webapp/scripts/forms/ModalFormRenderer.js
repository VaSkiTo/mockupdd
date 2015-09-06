var ModalFormRenderer = FormRenderer.extend({
	
	init: function(domElement,model,modalId){
		this._super(model);
		this._enabled = true;
		var self = this;
		this._domElement = domElement;
		this._modal = $("#"+modalId);
		this.setContainer($(".modal-body",this._modal));
		this.setButtonsContainer($(".modal-footer",this._modal));
		this._domElement.on("dblclick",function(){
			if(!self._enabled)
				return;
			var form = new Form(self._model);
			form.setButtons({
				"Cancel": {
					style: "default",
					action: function(form){
						self.triggerClose();
					}
				},
				"Delete": {
					style: "danger",
					action: function(form){
						self.triggerDelete();
					}
				},
				"Save": {
					style: "primary",
					action: function(form){
						form.save();
						self.triggerClose();
					}
				},
				
			})
			self._forms = [];
			self.pushForm(form);
			self._modal.modal("show");
		})
	},
	
	disable: function(){
		this._enabled = false;
	},
	
	enable: function(){
		this._enabled = true;
	},
	
	popForm: function(){
		this._super();
		if(this._forms.length == 0){
			this._modal.modal("hide");
		}
	}
	
})