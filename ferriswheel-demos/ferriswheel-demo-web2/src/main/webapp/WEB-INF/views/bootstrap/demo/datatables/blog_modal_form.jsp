<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ include file="/static/tags/taglibs.jsp" %>

<div class="row-fluid sortable">
	<div class="box span12">
		<div class="box-content">
			<form id="blog_form" class="form-horizontal">
				<fieldset>
					<input type="hidden" name="id" value="" /> <input type="hidden"
						name="creater" value="" />
					<div class="control-group">
						<label class="control-label" for="title"><fmt:message
								key="demo.blog.col.title" /></label>
						<div class="controls">
							<input class="input-xlarge" id="title" name="title" type="text"
								value="">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="author"><fmt:message
								key="demo.blog.col.author" /></label>
						<div class="controls">
							<input class="input-xlarge" id="author" name="author" type="text"
								value="">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="category"><fmt:message
								key="demo.blog.col.category" /></label>
						<div class="controls">
							<input class="input-xlarge" id="category" name="category"
								type="text" value="">
						</div>
					</div>
					<div class="control-group">
						<label class="control-label" for="url"><fmt:message
								key="demo.blog.col.url" /></label>
						<div class="controls">
							<input class="input-xlarge" id="url" name="url" type="text"
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
								key="demo.blog.col.publishDate" /></label>
						<div class="controls">
							<input class="input-xlarge datepicker" id="publishDate"
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
	var actionUrl = '${ACTIONURL}';
	function formsubmit() {
		$.post(actionUrl, $(blogform).serializeArray(), function(msg) {
			alert(msg);
		});
	}
</script>