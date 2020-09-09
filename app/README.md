What is FragmentManager? What does it do?

```viewPager.offscreenPageLimit = n``` loads n screens to left and n screens to right of current fragment.</br>
<i>https://black-jin0427.tistory.com/94</i>

## Solved

### Bottom Navigation View
Sets N 'buttons'.</br>
1) from 'activity_main.xml', bring up BottomNavigationView.</br>
2-1) from create 'menu' folder in 'res' directory and make new xml file. (Here it's navigation.xml)</br>
2-2) in navigation.xml, each 'item' corresponds to a clickable 'button'.</br>
3) from 'activity_main.xml', in BottomNavigationView attributes set ```app:menu="@menu/navigation"```</br>

### View Pager
To connect View Pager with Fragments you need adapter as mediator between them.
1) define new adapter class. (Here it's MainPagerAdapter.kt)
2) in MainActivity's onCreateView(), write below to set ViewPager's adapter as your own adapter class instance.
```kotlin
viewPager.adapter = MainPagerAdapter(supportFragmentManager)
viewPager.offscreenPageLimit = 2
```

### Linking View Pager with Bottom Navigation View
So far with only above implementations the page displayed on View Pager does not match with what Bottom Navigation View
tells which screen you're seeing. To link those two you can add page change listener with below.
```kotlin
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
                //blank
            }

            override fun onPageScrollStateChanged(state: Int) {
                //blank
            }

            override fun onPageSelected(position: Int) {
                bottomNavigationView.menu.getItem(position).isChecked = true
            }
        })
```
Simple.


### ViewPager.addOnPageChangeListener
```ViewPager.addOnPageChangeListener()``` takes a class object that implements ```ViewPager.OnPageChangeListener``` interface.
Unlike the common case of ```setOnClickListener{}``` this interface requires 3 methods to implement so you can't directly
pass a function and expect SAM conversion to work like magic.