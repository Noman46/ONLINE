<div class="container">
	<div class="row">

		<!-- to dispplay the sidebar -->
		<div class="col-md-3">
			<%@include file="./shared/sidebar.jsp"%>

		</div>
		<!-- to dispplay the products -->
		<div class="col-md-9">
			<div class="row">
				<div class="col-lg-12">

					<c:if test="${userClickViewProducts == true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li> &nbsp&nbsp&nbsp
							<li class="active">All Products</li>
						</ol>

					</c:if>
					<c:if test="${userClickCategoryProducts == true}">
						<ol class="breadcrumb">
							<li><a href="${contextRoot}/home">Home</a></li> &nbsp&nbsp&nbsp
							<li class="active">${category.name}</li>
						</ol>
					</c:if>



				</div>

			</div>

		</div>


	</div>

</div>