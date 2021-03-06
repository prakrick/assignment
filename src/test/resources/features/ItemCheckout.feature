Feature: verify checkout

Background:
		Given User is on homepage
		And User closes the login modal

@regression
Scenario: Verify User is able to place order using net banking

Given User clicks on category "Mobiles"
And User mouse hovers on section "Electronics"
And User clicks on list item "OPPO"
And User clicks on View All button for mobiles under "10K"
When User clicks on item "OPPO A33 (Moonlight Black, 32 GB)"
Then User navigates to the item description page of "OPPO A33 (Moonlight Black, 32 GB)"
When User enters product delivery pincode "781012"
Then User verifies product avaiable for entered pincode
When User clicks on Add to Cart button
Then User verifies item "OPPO A33 (Moonlight Black, 32 GB)" exists in cart
When User clicks on Flipkart home icon
And User clicks on Cart
Then User verifies item "OPPO A33 (Moonlight Black, 32 GB)" exists in cart
When User clicks on Place Order button
And User logs in as a "Regular" customer during checkout
Then User verifies item "OPPO A33 (Moonlight Black, 32 GB)" present in order summary
When User clicks Continue button on order summary
And User selects net banking as payment option
And User selects "CORPORATION" from Bank list
#And User clicks on PAY button
