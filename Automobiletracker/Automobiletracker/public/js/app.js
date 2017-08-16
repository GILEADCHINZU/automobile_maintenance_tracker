
function intFormat(n) {
    var regex = /(\d)((\d{3},?)+)$/;
    n = n.split(',').join('');
    while(regex.test(n)) {
        n = n.replace(regex, '$1,$2');
    }
    return n;
}
function numFormat(n) {
    var pointReg = /([\d,\.]*)\.(\d*)$/, f;
    if(pointReg.test(n)) {
        f = RegExp.$2;
        return intFormat(RegExp.$1) + '.' + f;
    }
    return intFormat(n);
}

function insertOptions(index, field) {
    var options = '<option value=""> -Select- </option>';
    insertOptionsBase(options, index, field);
}

function insertOptionsBase(opts, index, field) {
    var options = opts;
    $("#"+field+"_options option.option_"+index).each(function (idx){
        var selected = '';
        if($(this ).attr("selected")==="selected") { selected = 'selected="selected"'; }
        options += '<option value="'+$(this ).val()+'" '+selected+'>'+$(this ).html()+'</option>';
    });
    $("#"+field+"_select").html(options);
    //$("#"+field+"_select").trigger("chosen:updated");
}

function insertAxises() {
    var stateIndex = $("#state_select").val();
    if(stateIndex !== "") {
        insertOptions(stateIndex, "axis");
        insertAreas();
    }
    $("#state_select").change(function(){
        var index = $(this).val();
        insertOptions(index, "axis");
        insertAreas();
    });
}

function insertAxises2() {
    var stateIndex = $("#primary_state_select").val();
    if(stateIndex !== "") {
        insertOptions(stateIndex, "primary_axis");
        insertAreas();
    }
    $("#primary_state_select").change(function(){
        var index = $(this).val();
        insertOptions(index, "primary_axis");
        insertAreas();
    });
}

function insertAxises3() {
    var stateIndex = $("#secondary_state_select").val();
    if(stateIndex !== "") {
        insertOptions(stateIndex, "secondary_axis");
        insertAreas();
    }
    $("#secondary_state_select").change(function(){
        var index = $(this).val();
        insertOptions(index, "secondary_axis");
        insertAreas();
    });
}

function insertAreas() {
    var axisIndex = $("#axis_select").val();
    if(axisIndex !== "") {
        insertOptions(axisIndex, "area");
    }
    $("#axis_select").change(function(){
        var index = $(this).val();
        insertOptions(index, "area");
    });
}

function insertAreas2() {
    var axisIndex = $("#primary_axis_select").val();
    if(axisIndex !== "") {
        insertOptions(axisIndex, "primary_area");
    }
    $("#primary_axis_select").change(function(){
        var index = $(this).val();
        insertOptions(index, "primary_area");
    });
}

function insertAreas3() {
    var axisIndex = $("#secondary_axis_select").val();
    if(axisIndex !== "") {
        insertOptions(axisIndex, "secondary_area");
    }
    $("#secondary_axis_select").change(function(){
        var index = $(this).val();
        insertOptions(index, "secondary_area");
    });
}