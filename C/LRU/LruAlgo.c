#include <stdio.h>
#include <stdbool.h>

void simulate_lru(int page_requests[], int num_requests, int num_frames) {
    int frames[num_frames];
    int last_used[num_frames]; // Timestamp array
    int page_faults = 0;

   
    for (int i = 0; i < num_frames; i++) {
        frames[i] = -1;
        last_used[i] = -1;
    }

    for (int time = 0; time < num_requests; time++) {
        int page = page_requests[time];
        bool hit = false;

        for(int i = 0; i < num_frames; i++){
            if(frames[i]==page){
                last_used[i]=time;
                hit=true;
                break;
            }
            else if(frames[i]==-1){
                break;
            }

        }
        if(!hit){ // page fault 

        
        if(page_faults < num_frames){
            // if the frame is not full or there is an empty slot 
            last_used[page_faults] = time;
            frames[page_faults] = page;
        }else{ // finding the least recently used frame index
            int minIndex = 0;
            int minValue = 1000;

            for(int i = 0 ;i < num_frames;i++){
               
                if(minValue>last_used[i]){
                    minValue = last_used[i];
                    minIndex = i;
                }
            }

            last_used[minIndex] = time;
            frames[minIndex] = page;

        }

        page_faults++;
        
        }
       
    
    }

    printf("Total Page Faults: %d\n", page_faults);
}

int main() {
    int requests[] = {1, 2, 3, 4, 1, 2, 5, 1, 2, 3, 4, 5};
    int num_requests = sizeof(requests) / sizeof(requests[0]);
    
    simulate_lru(requests, num_requests, 3);
    return 0;
}