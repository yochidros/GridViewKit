# GridViewKit

# Abstract
 - It's help you for using grid view.
 - it's use easy very.
 - Gridview orientation order is horizontal only. not order vertical. it's resolve order orientation.
 - GridViewKit sort items order vertical or horizontal.
 - GirdViewKit can run no extension. but, you implement grid item using gridable.

## How to use
 - It's simplfy,
   # 1: implement you want to display grid item.  
   ## ex.)  
      
      
    ~~~
    data class Gift(

     var id: Int? = 0,

     var name: String? = null,

     var order: Int? = null,

    /*
      .... 
    */

     ) : Serializable, Gridable<Gift> {

     override var value: Gift? = this
     override var resourceId: Int = /* you set layout resource id */

     override fun bind(itemView: View) {
       /*... something ... */
     }

     override fun getInflatedView(context: Context): View {
       return LayoutInflater.from(context).inflate(resourceId, null)
     }
    }
   ~~~  
   # 2: Set Grid Adapter  
    ## ex.)  
    ~~~
      gridview.adapter = GridAdapter(context, items, null, GridAdapter.VERTICAL, columnNum, rowNum)

    ~~~
 
    # 3: (option) If empty item is custom layout...
    ## ex.)  
    ~~~
      gridview.adapter = GridAdapter(context, items, CustomGridEmpty(), GridAdapter.VERTICAL, columnNum, rowNum)

    ~~~
    
    ## Custom Grid Empty class ##

    ~~~
    class GridGiftEmpty<V> : GridEmpty<V>(null) {
        override var value: V? = null
        override var resourceId: Int = /* set your custom empty layout resource id */

        override fun bind(itemView: View) {
          /* something */
        }

        override fun getInflatedView(context: Context): View {
           return LayoutInflater.from(context).inflate(resourceId, null)
        }
    }

    ~~~
