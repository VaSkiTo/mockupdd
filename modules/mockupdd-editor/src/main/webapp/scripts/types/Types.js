Type = Class.extend({
	
	posibleValues : function() {
	},
	getTypeView : function(value) {
		return (new window[this._typeViewName](value));
	}
})

Type.typeClasses = {}
Type.types = {}

TYPES = Type.types;

Type.extend = function(typeName, prop, parametrized, complex) {
	prop = prop || {};
	prop.__typeName =  {init: typeName};
	prop.__complex = {init: complex}
	prop.__typeViewName = {init: typeName+"View"};
	prop.isComplex = function(){return this.getComplex()} //More natural.
	parametrized = parametrized || false;
	var ret = Class.extend.apply(this,[prop]);
	ret.extend = arguments.callee;
	Type.typeClasses[typeName] = ret;
	if(!parametrized)
		Type.types[typeName] = new ret();
	return ret;
}

Type.extend("String");
Type.extend("Text");
Type.extend("Color");
Type.extend("FontSize");
Type.extend("BootstrapStyle");
Type.extend("Pixels");
Type.extend("Number");
Type.extend("Action",null, false, true);
Type.extend("Validation",null, false, true);
Type.extend("Event", null, false, true);
Type.extend("List",{
	
	init: function(itemType){
		this.setItemType(itemType);
	},

	__itemType : {}
	
},true)