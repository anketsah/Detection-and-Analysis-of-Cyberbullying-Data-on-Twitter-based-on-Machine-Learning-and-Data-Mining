# Data Visualization for Cyberbullying content

import matplotlib.pyplot as plot 
  
# labels are defined 
dataLabels = ['Cyberbullying ', 'Non-Cyberbullying '] 
  
# Each label's area covered 
partition = [9.754,0.246] 
  
# Colours for labels 
col = ['red', 'green'] 
  
# Create Pie chart
plot.pie(partition, labels = dataLabels, colors=col,  
        startangle=5, shadow = True, explode = (0, 0.1), 
        radius = 1.2, autopct = '%1.3f%%') 
  
plot.title("Cyberbullying Data Visualization")
plot.legend(bbox_to_anchor=(1, 1), loc=2, borderaxespad=1) 
  
# Display the chart
plot.show() 
