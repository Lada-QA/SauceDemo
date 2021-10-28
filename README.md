> **CheckList** for testing of websait **https://www.saucedemo.com**

1. > +**SMOKE** -TEST; **id** - Reg_1; **Summary** - Verification of authorization with partial filling in of fields(only login and only password); **Module** - Registration; **Status** - `Failed`; **Comment** - when filling in the login field or the password field, it is impossible to go to the products page;
2. > +**SMOKE**-TEST;  **id** - Red_2; **Summary** - Checking for errors when filling out the form incorrectly(without Username and without password); **Module** - Registration; **Status** - `Passed`; **Comment** - when filling in the login field or the password field, the message displayed correctly;
3. > +**Regression**-TEST; **id** - Cart_1; **Summary** - Checking the **button "Remove"** on the shopping Cart Page (click); **Module** - CartPage; **Status** - `Passed` ; **Comment** - ;
4. > +**Regression**-TEST; **id** - Cart_2; **Summary** - Checking the **button "Checkout"** on the shopping Cart Page; **Module** - CartPage; **Status** - `Passed` ; **Comment**.
5. > +**SMOKE** -TEST; **id** - CheckInf_1; **Summary** - Checking the "CHECKOUT: YOUR INFORMATION page"  complete filling out of the form with valid data; **Module** - Checkout-step-one; **Status** - ; **Comment** - ;
 