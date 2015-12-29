<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/static/tags/taglibs.jsp" %>

<div class="row-fluid sortable">
	<div class="box span12">
		<div class="box-content">
			<form id="table_create_form" class="form-horizontal">
				<fieldset>
					<input type="hidden" name="id" value="" /> <input type="hidden"
						name="creater" value="" />
					<div class="control-group">
						<label class="control-label" for="title"><fmt:message
								key="demo.blog.col.title" /><em>*</em></label>
						<div class="controls">
							<input class="input-xlarge required" id="title" name="title" type="text"
								value="" placeholder="enter title">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="author"><fmt:message
								key="demo.blog.col.author" /><em>*</em></label>
						<div class="controls">
							<input class="input-xlarge required" id="author" name="author" type="text"
								value="">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="category"><fmt:message
								key="demo.blog.col.category" /><em>*</em></label>
						<div class="controls">
							<input class="input-xlarge required" id="category" name="category"
								type="text" value="">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="url"><fmt:message
								key="demo.blog.col.url" /><em>*</em></label>
						<div class="controls">
							<input class="input-xlarge required" id="url" name="url" type="text"
								value="">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="other"><fmt:message
								key="demo.blog.col.other" /></label>
						<div class="controls">
							<input class="input-xlarge" id="other" name="other" type="text"
								value="">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="publishDate"><fmt:message
								key="demo.blog.col.publishDate" /><em>*</em></label>
						<div class="controls">
							<input class="input-xlarge datepicker required" id="publishDate"
								type="text" name="publishDate" value="">
						</div>
					</div>
				</fieldset>
			</form>

		</div>
	</div>
	<!--/span-->

</div>
<!--/row-->

<script type="text/javascript">
var _validator_create = $("#table_create_form").validate({
	errorPlacement: function(error, element) {
	    if ( element.is(":radio") ) 
	        error.appendTo ( element.parent() ); 
	    else if ( element.is(":checkbox") ) 
	        error.appendTo ( element.parent() ); 
	    else if ( element.is("input[name=captcha]") ) 
	        error.appendTo ( element.parent() ); 
	    else {
	    	error.insertAfter(element); 	
	    }
	}
})
</script>