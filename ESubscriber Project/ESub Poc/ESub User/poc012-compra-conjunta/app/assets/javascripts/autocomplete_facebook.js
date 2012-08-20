$(function() {
		$( "#project" ).autocomplete({
			source: function( request, response ) {
				$.ajax({
					url: "http://localhost:3000/welcome/autocomplete_friend_name.json",
					dataType: "json",
					data: {
						featureClass: "P",
						style: "full",
						maxRows: 12,
						name_startsWith: request.term
					},
					success: function( data ) {
					console.log("Sucesso")
						response( $.map( data, function( item ) {
							return {
								label: item.name,
								value: item.name,
								id_social: item.id_social
							}
						}));
					}
				});
			},
			minLength: 3			
		}).data( "autocomplete" )._renderItem = function( ul, item ) {
			return $( "<li></li>" )
				.data( "item.autocomplete", item )
				.append( 
"<a><img src =http://graph.facebook.com/"+item.id_social+"/picture />" + item.label + "<br>" + item.value + "</a>" )
				.appendTo( ul );
		};
	});
