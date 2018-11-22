Check out counter Application for an online retail store.
===========================================================
Understanding:
1.	Retail store has products of catagories A,B,C with the taxes 10%,20%,and 0% respectively.
System should be able to display itemized bill, like
Sr.No.	Item(category)	quantity	cost	price	tax(%)	TaxAmt	Amount
---------------------------------------------------------------------------
1.		A1(A)			2			100		200		10		20		220
2.		B1(B)			2			100		200		20		40		240
C.		C1(C)			2			100		200		00		00		200
===========================================================================
		Total Payble						600				60		660
		
2.	Admin/StoreManager should be able to add/remove/update the products

3.	Customer should be able to select items and add to shopping cart, and view it before checkout

Aussmption : 
1.	User management and authentication/autherization is kept out of scope for version 1
2.	UI is 	kept out of scope for version 1, only server development is done
3.	Inventory management is not cosidered. Considering unlimited quantity available
4.	Product Addition/Removal/Modification is out of scope, and pre loaded products will be displayed
5.	ShoppingCarts functionality will not maintain and DB storage, considered shoppingCart as input for billing
6.	No DB/persistent layer is addded


Aproach : 
/products GET service to list all products : producs configured in application.properties, list can be edited or extended
/bills	GET	service will take the order and customer information and will return the bill object

Conclusion :
Code is tested locally using JUNIT testecase	
