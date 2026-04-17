class MedianUsingQuickSelect:
    def partiton(self,arr,l,h):
        pivot=arr[h]
        i=l-1
        for j in range(l,h):
            if arr[j]<=pivot:
                i+=1
                arr[i],arr[j]=arr[j],arr[i]

        arr[i+1],arr[h]=arr[h],arr[i+1]
        return i+1
    def quick_select(self,arr,l,h,k):
        if l<=h:
            pi=self.partiton(arr,l,h)
            if pi==k:
                return arr[pi]
            elif pi>k:
                return self.quick_select(arr,l,pi-1,k)
            else:
                return self.quick_select(arr,pi+1,h,k)
        return None
    
    
    